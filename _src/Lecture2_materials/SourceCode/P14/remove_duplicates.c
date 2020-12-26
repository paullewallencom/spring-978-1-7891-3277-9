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

void remove_duplicates(struct node* source) {
  if (source == NULL) {
    return;
  }

  struct node* curr = source->next;
  struct node* prev = source;

  while (curr != NULL) {
    if (curr != NULL && curr->data == prev->data) {
      prev->next = curr->next;
      curr->next = NULL;
      free(curr);

      curr = prev->next;
      continue;
    }
    prev = curr;
    curr = curr->next;
  }
}


int main() {
  struct node* head = NULL;
 
  append_data(&head, 4);
  append_data(&head, 6);
  append_data(&head, 8);
  append_data(&head, 8);
  append_data(&head, 8);
  append_data(&head, 12);
  append_data(&head, 12);
  print_list(head);

  remove_duplicates(head);
  print_list(head);
}
