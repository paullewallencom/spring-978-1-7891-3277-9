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

void insert_nth(struct node** headRef, int data, int n) {
  assert(headRef != NULL);
  assert(n >= 0);

  if (n == 0 || *headRef == NULL) {
    struct node* headNode = create_node(data);
    headNode->next = *headRef;
    *headRef = headNode;
    return;
  }

  int index = 0;
  struct node* head = *headRef;
  struct node* prev = *headRef;

  while (head != NULL && index < n) {
    prev = head;
    head = head->next;
    index++;
  }

  if (prev != NULL) {
    prev->next = create_node(data);
    prev->next->next = head;
  }
}


int main() {
  struct node* head = NULL;
 
  append_data(&head, 4);
  print_list(head);
  append_data(&head, 5);
  print_list(head);
  append_data(&head, 6);
  print_list(head);

  insert_nth(&head, 0, 0);
  print_list(head);

  insert_nth(&head, 333, 1);
  print_list(head);

  insert_nth(&head, 444, 10);
  print_list(head);
}
