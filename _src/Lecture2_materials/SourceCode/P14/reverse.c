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

struct node* reverse(struct node* list) {
  if (list == NULL || list->next == NULL) {
    return list;
  }

  struct node* curr = list->next;
  struct node* prev = list;
  prev->next = NULL;

  while (curr != NULL) {
    struct node* next = curr->next;

    curr->next = prev;
    prev = curr;
    curr = next;
  }
  
  return prev;
}

int main() {
  struct node* source = NULL;
  struct node* dest = NULL;

  append_data(&source, 4);
  //  append_data(&source, 10);
  append_data(&source, 20);
  print_list(source);
  print_list(reverse(source));

  append_data(&dest, 2);
  append_data(&dest, 9);
  append_data(&dest, 11);
  append_data(&dest, 12);
  print_list(dest);
  print_list(reverse(dest));
}
