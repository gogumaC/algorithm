/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {

    int* res = (int *)malloc(sizeof(int)*2);
    *returnSize = 2;

    for(int i=0; i<numsSize; i++){
        for(int j=i+1; j<numsSize; j++){
            int a = nums[i];
            int b = nums[j];

            if(a+b == target){
                res[0]=i;
                res[1]=j;
                return res;
            }
        }
    }

    return res;
    
}