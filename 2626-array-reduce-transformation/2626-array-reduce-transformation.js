/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    if(nums.length == 0)
        return init;
    let prevVal = init;
    nums.forEach((num)=>{
        prevVal =  fn(prevVal,num);
    })
    return prevVal;
};