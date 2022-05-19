//given a sorted array return two elements that has the sum equal to target value k
function twoSum(nums, k) {
    var start = 0
    var end = nums.length - 1
    var count = 0;
    while (start < end) {
        if (nums[start] + nums[end] == k) {
            count++
            start++
            end--
        } else if (nums[start] + nums[end] > k) {
            end--
        } else {
            start++
        }
    }
    return count
}


console.log(twoSum([1, 2, 3, 4, 5], 8)); // [3, 5]
console.log(twoSum([1, 4, 4, 5, 5, 5, 6, 6, 11], 11)); // [3, 5]
