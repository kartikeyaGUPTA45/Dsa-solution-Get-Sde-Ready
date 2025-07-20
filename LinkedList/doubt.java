/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    let temp1 = head;
    let isRec =  true;
    function rec(node){

        if(node == null)
         return ;

        rec(node.next);
        if(temp1.val != node.val)
        isRec=false;
                console.log('temp1:',temp1.val);
        // console.log('revNode:',revNodes.val);
        temp1=temp1.next;

    }
    rec(head);
    return isRec;
};
