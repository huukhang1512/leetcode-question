# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstToGst(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.prev_sum = 0
        
        def update_node(node):
            if node:
                update_node(node.right)
                node.val += self.prev_sum
                self.prev_sum = node.val
                update_node(node.left)
        update_node(root)
        return root
            