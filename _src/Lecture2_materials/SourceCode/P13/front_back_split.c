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

void front_back_split(struct node* source,
		      struct node** frontRef,
		      struct node** backRef) {
  assert(frontRef != NULL &&  backRef != NULL);

  if (source == NULL) {
    *frontRef = NULL;
    *backRef = NULL;
    return;
  }

  if (source->next == NULL) {
    *frontRef = source;
    *backRef = NULL;
    return;
  }

  struct node* slow = source;
  struct node* fast = source;
  while (fast != NULL) {
    fast = fast->next;
    if (fast == NULL) {
      break;
    }
    fast = fast->next;
    if (fast != NULL) {
      slow = slow->next;
    }
  }

  *frontRef = source;
  *backRef = slow->next;
  slow->next = NULL;
}


int main() {
  struct node* head = NULL;
 
  append_data(&head, 4);
  append_data(&head, 6);
  append_data(&head, 8);
  append_data(&head, 10);
  append_data(&head, 12);
  print_list(head);

  struct node* front = NULL;
  struct node* back = NULL;

  front_back_split(head, &front, &back);
  print_list(front);
  print_list(back);
}
