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

void move_node(struct node** sourceRef, struct node** destRef) {
  assert(sourceRef != NULL && destRef != NULL);
  if (*sourceRef == NULL) {
    return;
  }

  struct node* node_to_move = *sourceRef;
  *sourceRef = (*sourceRef)->next;
  node_to_move->next = *destRef;
  *destRef = node_to_move;
}


int main() {
  struct node* source = NULL;
  struct node* dest = NULL;

  append_data(&source, 4);
  //  append_data(&source, 6);
  //append_data(&source, 8);
  print_list(source);
  //  append_data(&dest, 8);
  //append_data(&dest, 9);
  //append_data(&dest, 11);
  //append_data(&dest, 12);
  print_list(dest);

  move_node(&source, &dest);
  print_list(source);
  print_list(dest);
}
