/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s) {
    let start = 0;
    let end = s.length -1;
    let count = 0;
    while(start < end){
        if(count > 1){
            return false;
        }
        if(s[start] !== s[end] && count <= 1){
            return deleteOneChar(start, end-1, s) || deleteOneChar(start + 1, end, s);
            
        }
        start++;
        end--;
    }
    return true;
};

const deleteOneChar = (start, end, s) => {
    while(start < end){
        if(s[start] !== s[end]){
            return false;
        }
        start++;
        end--;
    }
    return true;
}