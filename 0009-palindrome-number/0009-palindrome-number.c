bool isPalindrome(int x) {

    int len = 0;
    int xx = x;
    do
    {
        xx/=10;
        len++;
    }while(xx);
    
    if(x<0)
    {
        len++;
    }

    char str[len+1];
    sprintf(str,"%d",x);

    for(int i=0; i<=len/2; i++)
    {
        if(str[i]!=str[len-i-1])
        {
            return false;
        }
    }

    return true;
    
}