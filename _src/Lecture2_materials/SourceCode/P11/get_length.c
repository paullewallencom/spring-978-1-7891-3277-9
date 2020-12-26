/* Pointer assignments program */

#include<stdio.h>

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

int main() {
  struct node a, b, c, d;
  a.next = &b;
  b.next = &c;
  c.next = &d;
  d.next = NULL;

  struct node* head = &a;
  printf("Length of list: %d\n", get_length(head));
  printf("Length of list: %d\n", get_length(&b));
  printf("Length of list: %d\n", get_length(&c));
  printf("Length of list: %d\n", get_length(&d));
  printf("Length of list: %d\n", get_length(NULL));
}
