/* Pointer assignments program */

#include<stdio.h>
#include<assert.h>
#include<stdlib.h>

struct node {
  int data;
  struct node* next;
};


int get_length(struct node* head) {
  int length = 0;
  while (head != NULL) {
    length++;
    head = head->next;
  }

  return length;
}

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

int main() {
  struct node* head = NULL;
 
  append_data(&head, 4);
  printf("Length: %d", get_length(head));
  append_data(&head, 5);
  printf("Length: %d", get_length(head));
  append_data(&head, 6);
  printf("Length: %d", get_length(head));
}
