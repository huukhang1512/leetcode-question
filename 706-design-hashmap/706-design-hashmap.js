
var MyHashMap = function() {
    this.array = new Array(13000);
    this.array.fill([]);
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */

let hashing = (key) => {
    return key % 13000;
}

MyHashMap.prototype.put = function(key, value) {
    let hashCode = key % this.array.length;
    for(let i = 0; i < this.array[hashCode].length;i++){
        if(this.array[hashCode][i][0] === key){
            this.array[hashCode][i][1] = value;
            return;
        }
    }
    this.array[hashCode].push([key, value]);
};

/** 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
    let hashCode = key % this.array.length;
    for(let i = 0; i < this.array[hashCode].length;i++){
        if(this.array[hashCode][i][0] === key){
            return this.array[hashCode][i][1];
        }
    }
    return -1;
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
    let hashCode = key % this.array.length;
    for(let i = 0; i < this.array[hashCode].length;i++){
        if(this.array[hashCode][i][0] === key){
            this.array[hashCode].splice(i,1);
        }
    }
    return;
};

/** 
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */