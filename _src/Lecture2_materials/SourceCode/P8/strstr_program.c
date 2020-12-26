/* String compare program */

#include<stdio.h>
#include<string.h>


char* my_strstr(const char* haystack, const char* needle) {
  if (haystack == NULL || needle == NULL) {
    return NULL;
  }

  while (*haystack != '\0') {
    if (*haystack == *needle) {
      const char* h = haystack;   
      const char* n = needle;
      while (*n != '\0' && *h == *n) {
	h++;
	n++;
      }
      if (*n == '\0') {
	return (char*) haystack;
      }
    }
    haystack++;
  }

  return NULL;
}

int main() {
  printf("strstr: %s my_strstr: %s \n", strstr("HELLO", "LO"), my_strstr("HELLO", "LO"));
  printf("strchr: %s my_strchr: %s \n", strstr("HELLO", "ELL"), my_strstr("HELLO", "ELL"));
  printf("strchr: %s my_strchr: %s \n", strstr("HELLO", "K"), my_strstr("HELLO", "K"));
  printf("strchr: %s my_strchr: %s \n", 
	 strstr("HELLOHELLLOO", "LLL"), my_strstr("HELLOHELLLOO", "LLL"));

}


