#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(void)
{
  int testCnt = 0;
  int houseN  = 0;
  int budget  = 0;
  int *housesCost;

  int exeCnt = 0;
  int ans = 0;
  int sum = 0;
  int temp = 0;
  scanf("%d", &testCnt);
  while(1)
  {
    ans = 0;
    sum = 0;
    temp = 0;
      
    scanf("%d %d", &houseN, &budget);
    housesCost = (int *) malloc(sizeof(int) * houseN); /// c++ 要轉型 void* to int*
    for(int i = 0; i < houseN; i++)
    {
      scanf("%d", &housesCost[i]);
    }

    for(int i = 0; i < houseN; i++)
    {
      for(int j = 0; j < houseN - 1; j++)
      {
        if(housesCost[j] > housesCost[j+1])
        {
          temp = housesCost[j];
          housesCost[j] = housesCost[j + 1];
          housesCost[j + 1] = temp;
        }
      }
    }

    while(sum + housesCost[ans] <= budget)
    {
      sum += housesCost[ans];
      ans++;
    }

    printf("Case #%d: %d", exeCnt + 1, ans);
    free(housesCost);
    exeCnt ++;
    if(exeCnt >= testCnt)
    {
      break;
    }
  }
}