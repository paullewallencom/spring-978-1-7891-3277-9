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

struct node* sorted_merge(struct node* a,
			  struct node* b) {
  if (a == NULL) {
    return b;
  } else if (b == NULL) {
    return a;
  }

  struct node* head;
  if (a->data < b->data) {
    head = a;
    a = a->next;
  } else {
    head = b;
    b = b->next;
  }
  head->next = NULL;
  
  struct node* curr = head;
  while(a != NULL && b != NULL) {
    if (a->data < b->data) {
      curr->next = a;
      a = a->next;
    } else {
      curr->next = b;
      b = b->next;
    }
    curr = curr->next;
  }

  if (a != NULL) {
    curr->next = a;
  } else {
    curr->next = b;
  }

  return head;
}

int main() {
  struct node* source = NULL;
  struct node* dest = NULL;

  append_data(&source, 4);
  append_data(&source, 10);
  append_data(&source, 20);
  print_list(source);
  
  append_data(&dest, 2);
  append_data(&dest, 9);
  append_data(&dest, 11);
  append_data(&dest, 12);
  print_list(dest);

  struct node* head = sorted_merge(dest, source);
  print_list(head);
}
