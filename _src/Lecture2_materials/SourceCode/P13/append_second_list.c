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

void append_second_list(struct node** list_a, struct node** list_b) {
  assert(list_a != NULL && list_b != NULL);

  if (*list_a == NULL) {
    *list_a = *list_b;
    *list_b = NULL;
    return;
  }

  struct node* head = *list_a;
  while (head->next != NULL) {
    head = head->next;
  }

  head->next = *list_b;
  *list_b = NULL;
}


int main() {
  struct node* head_a = NULL;
 
  append_data(&head_a, 4);
  print_list(head_a);
  append_data(&head_a, 6);
  print_list(head_a);
  append_data(&head_a, 8);
  print_list(head_a);

  struct node* head_b = NULL;
 
  append_data(&head_b, 14);
  print_list(head_b);
  append_data(&head_b, 16);
  print_list(head_b);
  append_data(&head_b, 18);
  print_list(head_b);

  //  append_second_list(&head_a, &head_b);
  //print_list(head_a);

  head_a = NULL;
  append_second_list(&head_a, &head_b);
  print_list(head_a);
}
