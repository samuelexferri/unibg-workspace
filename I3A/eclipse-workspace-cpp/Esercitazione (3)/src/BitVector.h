#ifndef BITVECTOR_H_
#define BITVECTOR_H_

typedef struct bitvector *bvref;

bvref makeBitVector(int n);

bvref add(bvref bv1, bvref bv2);
bvref or(bvref bv1, bvref bv2);
bvref not(bvref bv1);

char* toString(bvref bv);

void delete(bvref bv);

#endif /* BITVECTOR_H_ */
