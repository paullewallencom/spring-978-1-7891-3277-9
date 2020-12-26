/* String compare program */

#include<stdio.h>
#include<string.h>


int my_strcmp(const char* str1, const char* str2) {
  if (str1 == NULL && str2 == NULL) {
    return 0;
  }

  if (str1 == NULL) {
    return 0 - *str2;
  }

  if (str2 == NULL) {
    return *str1;
  }

  const char* ch1 = str1;
  const char* ch2 = str2;

  while (*ch1 != '\0' && *ch2 != '\0') {
    // If we find any mismatch we return, otherwise continue
    if (*ch1 != *ch2) {
      // ASCII characters are integers at heart, they correspond to ASCII codes
      // 'A' starts at 65 and 'a' starts at 97 with the other capital and smaller
      // case letters following them.
      return *ch1 - *ch2;
    }

    ch1++;
    ch2++;
  }
  
  // String 1 has reached the end and string 2 has not. This means
  // that string 1 is smaller than string 2. We return
  // a negative integer
  if (*ch1 == '\0' && *ch2 != '\0') {
    return 0 - *ch2;
  }

  // String 2 has reached the end and string 1 has not. This means
  // that string 1 is larger than string 2. We return a positive
  // integer
  if (*ch1 != '\0' && *ch2 == '\0') {
    return *ch1;
  }

  return 0;
}

int main() {

  printf("strcmp: %d my_strcmp: %d \n", strcmp("HELLO", "HELLo"), my_strcmp("HELLO", "HELLo"));
  printf("strcmp: %d my_strcmp: %d \n", strcmp("HELLO", ""), my_strcmp("HELLO", ""));  
  printf("strcmp: %d my_strcmp: %d \n", strcmp("boom", "boo"), my_strcmp("boom", "boo"));  
  printf("strcmp: %d my_strcmp: %d \n", strcmp("boo", "boom"), my_strcmp("boo", "boom"));  
  printf("strcmp: %d my_strcmp: %d \n", strcmp("boO", "boO"), my_strcmp("boO", "boO"));  

  printf("my_strcmp: %d \n", my_strcmp(NULL, NULL));
  printf("my_strcmp: %d \n", my_strcmp("HELLO", NULL));
  printf("my_strcmp: %d \n", my_strcmp(NULL, "HELLO"));

}


