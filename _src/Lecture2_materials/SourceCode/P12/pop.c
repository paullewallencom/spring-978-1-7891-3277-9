/* Pointer assignments program */

#include<stdio.h>
#include<assert.h>
#include<stdlib.h>

struct node {
  int data;
  struct node* next;
};

void append_data(struct node** headRef, int data) {
  assert(headRef != NULL);
  if (*headRef == NULL) {
   *headRef = (struct node*)malloc(sizeof(struct node));
   (*headRef)->data = data;
   (*headRef)->next = NULL;
    return;
  } 

  struct node* head = *headRef;
  while (head->next != NULL) {
    head = head->next;
  }

    head->next = (struct node*)malloc(sizeof(struct node));
    head->next->data = data;
    head->next->next = NULL;
}

int pop(struct node** headRef) {
  assert(headRef != NULL);

  if (*headRef != NULL) {
    printf("Freeing: %d", (*headRef)->data);
    struct node* next = (*headRef)->next;

    int data = (*headRef)->data;
    (*headRef)->next = NULL;
    free(*headRef);
    
    *headRef = next;

    return data;
  }

  assert(0);
}

int main() {
  struct node* head = NULL;
 
  append_data(&head, 4);
  append_data(&head, 5);
  append_data(&head, 6);
  
  printf("Pop: %d", pop(&head));
  printf("Pop: %d", pop(&head));
  printf("Pop: %d", pop(&head));
}
