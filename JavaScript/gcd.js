var x = Number(readline());
var y = Number(readline());
function gcd_two_numbers(x, y) {
    if(x===0) return y ; 
    if(y===0) return x ; 

    if(x===y) return x; 
    if(x > y) 
    return gcd_two_numbers(x-y , y) ; 
    else return gcd_two_numbers(x, y-x);  

}
print(gcd_two_numbers(x, y));
/* 
time complexity O(log(min(x,y))) ; space complexity O(1);  
Sample input: 
49
56
output:
7
*/
