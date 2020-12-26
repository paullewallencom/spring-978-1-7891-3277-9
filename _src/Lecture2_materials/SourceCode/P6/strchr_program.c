/* String compare program */

#include<stdio.h>
#include<string.h>


char* my_strchr(const char* str, int c) {
  if (str == NULL) {
    return NULL;
  }

  while (*str != '\0') {
    if (*str == c) {
      return (char*) str;
    }
    str++;
  }

  return NULL;
}

int main() {
  printf("strchr: %c my_strchr: %c \n", *strchr("HELLO", 'O'), *my_strchr("HELLO", 'O'));
  printf("strchr: %c my_strchr: %c \n", *strchr("HELLO", 'H'), *my_strchr("HELLO", 'H'));
}


