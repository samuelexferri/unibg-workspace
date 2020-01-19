#ifndef CANE_H_
#define CANE_H_

typedef void *caneref;

caneref make(char *nome);

void abbaia(caneref);

void delete(caneref);

#endif /* CANE_H_ */
