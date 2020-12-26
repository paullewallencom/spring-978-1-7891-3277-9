/* Pointer assignments program */

#include<stdio.h>

struct node {
  int data;
  struct node* next;
};

struct node* get_nth(struct node* head, int n) {
  if (n < 0) {
    return NULL;
  }

  int index = 0;
  while (head != NULL && index < n) {
    index++;
    head = head->next;
  }

  return head;
}

int main() {
  struct node a, b, c, d;
  a.data = 100;
  a.next = &b;
  b.data = 200;
  b.next = &c;
  c.data = 300;
  c.next = &d;
  d.data = 400;
  d.next = NULL;

  struct node* head = &a;

  printf("getNth: %d\n", get_nth(head, 0)->data);
  printf("getNth: %d\n", get_nth(head, 1)->data);
  printf("getNth: %d\n", get_nth(head, 2)->data);
  printf("getNth: %d\n", get_nth(head, 3)->data);

}
