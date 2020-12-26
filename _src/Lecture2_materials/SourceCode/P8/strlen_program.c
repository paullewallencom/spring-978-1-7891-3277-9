/* String length program */

#include<stdio.h>

size_t my_strlen(const char* str) {
  if (str == NULL) {
    return 0;
  }

  int length = 0;
  const char *ch = str;
  while (*str != '\0') {
    length++;
    str++;
  }
  return length;
}

int main() {
  size_t len = my_strlen("Hello World");
  printf("Length is %lu \n", len);

  char *another_string = "How are you?";
  len = my_strlen(another_string);
  printf("Length is %lu \n", len);

  char *null_string = NULL;
  len = my_strlen(null_string);
  printf("Length is %lu \n", len);

  char *empty_string = "";
  len = my_strlen(empty_string);
  printf("Length is %lu \n", len);

}


