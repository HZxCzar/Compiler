typedef unsigned int size_t;

int scanf(const char *format, ...);

int printf(const char *format, ...);

int sprintf(char *str, const char *format, ...);

void *malloc(size_t size); // NOLINT

void print(char *s) { printf("%s", s); }

void println(char *s) { printf("%s\n", s); }

void printInt(int n) { printf("%d", n); }

void printlnInt(int n) { printf("%d\n", n); }

int __builtin_array_size(void *array) { return ((int *)array)[-1]; }

void *_malloc(int size) { return malloc(size); }

int *__malloc_array(int length,
                    int size) { // size 为每个元素占几个字节，length 为数组长度
  int *tmp = (int *)malloc(size * length + 4);
  tmp[0] = length;
  return tmp + 1;
}

char *getString() {
  char *s = malloc(102 * sizeof(char));
  scanf("%s", s);
  return s;
}

int getInt() {
  int n;
  scanf("%d", &n);
  return n;
}

char *toString(int i) {
  char *s = malloc(12 * sizeof(char));
  sprintf(s, "%d", i);
  return s;
}

char *Bool_string_toString(_Bool i) {
  char *s = malloc(12 * sizeof(char));
  if (i) {
    sprintf(s, "1");
  } else {
    sprintf(s, "0");
  }
  return s;
}

int __string_length(char *s) {
  int i = 0;
  while (s[i] != '\0') {
    ++i;
  }
  return i;
}

char *__string_substring(char *s, int left, int right) {
  int len = right - left;
  char *result = (char *)malloc(sizeof(char) * (len + 1));
  for (int i = 0; i < len; i++) {
    result[i] = s[left + i];
  }
  result[len] = '\0';
  return result;
}

int __string_parseInt(char *s) {
  int result = 0;
  int i = 0;
  if (s[0] == '-') {
    i = 1;
  }
  for (; s[i] != '\0'; i++) {
    result = result * 10 + (s[i] - '0');
  }
  if (s[0] == '-') {
    result = -result;
  }
  return result;
}

int __string_ord(char *s, int i) { return s[i]; }

int __string_compare(char *s1, char *s2) {
  int i = 0;
  while (s1[i] != '\0' && s2[i] != '\0') {
    if (s1[i] != s2[i]) {
      return s1[i] - s2[i];
    }
    ++i;
  }
  return s1[i] - s2[i];
}

char *__string_concat(char *s1, char *s2) {
  int len1 = __string_length(s1);
  int len2 = __string_length(s2);
  char *result = (char *)malloc(sizeof(char) * (len1 + len2 + 1));
  for (int i = 0; i < len1; i++) {
    result[i] = s1[i];
  }
  for (int i = 0; i < len2; i++) {
    result[len1 + i] = s2[i];
  }
  result[len1 + len2] = '\0';
  return result;
}

void __string_copy(char **s1, char *s2) {
  int len = __string_length(s2);
  *s1 = (char *)malloc(sizeof(char) * (len + 1));
  for (int i = 0; i < len; i++) {
    (*s1)[i] = s2[i];
  }
  (*s1)[len] = '\0';
  return;
}