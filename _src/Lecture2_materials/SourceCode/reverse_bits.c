/* Pointer assignments program */

#include<stdio.h>

int reverse_bits(int num) {
  int reverse_num = 0;
  unsigned int count = sizeof(int) * 8 - 1;

  while (num != 0) {
    int last_bit = num & 1;
    reverse_num = reverse_num | last_bit;
    reverse_num = reverse_num << 1;
    num = num >> 1;
    count--;
  }

  reverse_num = reverse_num << count;

  return reverse_num;
}

void print_bits(int num) {
  unsigned int check_bit = 1 << (sizeof(int) * 8 - 1);

  while (check_bit != 0) {
    int result = num & check_bit;
    if (result == check_bit) {
      printf("%d ", 1);
    } else {
      printf("%d ", 0);
    }

    check_bit = check_bit >> 1;
  }

  printf("\n");
}

int main() {
  print_bits(8);
  print_bits(reverse_bits(8));
  print_bits(2344);
  print_bits(reverse_bits(2344));
  print_bits(4567);
  print_bits(reverse_bits(4567));
}
