/* String concatenate program */

#include<stdio.h>
#include<string.h>


char* my_strcat(char* dest, const char* src) {
  if (dest == NULL || src == NULL) {
    return dest;
  }

  char* d = dest;
  while (*d != '\0') {
    d++;
  }

  while (*src != '\0') {
    *d = *src;
    d++;
    src++;
  }
  *d = '\0';

  return dest;
}

int main() {
  char dest[100] = "Hello ";
  char src[50] = "World!";

  printf("boo %s", my_strcat(dest, src));

}


