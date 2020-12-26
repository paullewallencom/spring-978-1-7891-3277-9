/* Pointer assignments program */

#include<stdio.h>
#include<assert.h>
#include<stdlib.h>


struct node {
  int data;
  struct node* next;
};

void print_list(struct node* head) {
  while (head != NULL) {
    printf("%d -> ", head->data);
    head = head->next;
  }
  printf("NULL\n");
}

struct node* create_node(int data) {
  struct node* newNode = (struct node*)malloc(sizeof(struct node));
  newNode->data = data;
  newNode->next = NULL;

  return newNode;
}

void append_data(struct node** headRef, int data) {
  assert(headRef != NULL);
  if (*headRef == NULL) {
    *headRef = create_node(data);
    return;
  } 

  struct node* head = *headRef;
  while (head->next != NULL) {
    head = head->next;
  }

  head->next = create_node(data);
}

void sorted_insert(struct node** headRef, int data) {
  assert(headRef != NULL);

  struct node* head = *headRef;
  struct node* prev = NULL;

  while (head != NULL && data > head->data) {
    prev = head;
    head = head->next;
  }

  struct node* newNode = create_node(data);

  if (prev != NULL) {
    prev->next = newNode;
  } else {
    *headRef = newNode;
  }

  newNode->next = head;
}


int main() {
  struct node* head = NULL;
 
  append_data(&head, 4);
  print_list(head);
  append_data(&head, 6);
  print_list(head);
  append_data(&head, 8);
  print_list(head);

  sorted_insert(&head, 5);
  print_list(head);

  sorted_insert(&head, 1);
  print_list(head);

  sorted_insert(&head, 333);
  print_list(head);

  sorted_insert(&head, 5);
  print_list(head);
}
