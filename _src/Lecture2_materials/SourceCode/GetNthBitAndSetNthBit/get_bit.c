/* Pointer assignments program */

#include<stdio.h>

int get_nth_bit(int num, int n) {
  int check_bit = 1 << n;

  int and_bit = num & check_bit;
  if (and_bit == check_bit) {
    return 1;
  }

  return 0;
}

int main() {
  printf("The bit at position: %d of number: %d is: %d\n", 3, 8, get_nth_bit(8, 3));
  printf("The bit at position: %d of number: %d is: %d\n", 64, 6, get_nth_bit(64, 6));
  printf("The bit at position: %d of number: %d is: %d\n", 32, 7, get_nth_bit(32, 7));
}
