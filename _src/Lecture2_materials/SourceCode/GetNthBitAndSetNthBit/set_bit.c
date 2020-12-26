/* Pointer assignments program */

#include<stdio.h>

int set_nth_bit_to_1(int num, int n) {
  int set_bit = 1 << n;

  int result = num | set_bit;
  
  return result;
}

int set_nth_bit_to_0(int num, int n) {
  int set_bit = 1 << n;
  set_bit = ~set_bit;

  int result = num & set_bit;
  
  return result;
}

int main() {
  printf("The bit at position: %d of number: %d is: %d\n", 3, 8, get_nth_bit(8, 3));
  printf("The bit at position: %d of number: %d is: %d\n", 64, 6, get_nth_bit(64, 6));
  printf("The bit at position: %d of number: %d is: %d\n", 32, 7, get_nth_bit(32, 7));
}
