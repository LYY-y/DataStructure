/**
 * 1.（6-1）BinaryTree<T>二叉树类增加以下成员方法，public 权限
 ①	BinaryTree<T> create(SeqList<T> inList, SeqList<T> postList);  //以中根和后根遍历序列构造二叉树
 ②	void leaf();	//输出叶子结点
 ③	BinaryNode<T> parent(BinaryNode<T> p);    //返回p结点的父母结点
 2.（6-2）实现以下对二叉树的操作，public static 修饰，要求一次遍历效率
 ①	void property3(BinaryTree<T> bitree);	//验证二叉树的性质3
 ②	void swap(BinaryTree<T> bitree);   //交换结点的左右子树，讨论3种遍历算法的可行性
 3.	在二叉链表存储结构上实现中序遍历的非递归算法。
 4.	在中序线索二叉树上实现求p结点在中根次序下的前驱结点。方法声明如下：
 public ThreadNode<T> inPrev(ThreadNode<T> p)

 * */
package ExperimentalReport;

import Chapter2.SeqList;
import Chapter6.BinaryNode;
import Chapter6.BinaryTree;

import javax.swing.tree.TreeNode;

public class Report4 {
    Report4 report4 = new Report4();

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        SeqList<String> inList = new SeqList<String>();
        SeqList<String> postList = new SeqList<String>();
        String inStr = "dbfegac";
        String postStr = "dfgebca";
        for (int i = 0; i < inStr.length(); i++){
            inList.insert(inStr.charAt(i)+"");
            postList.insert(postStr.charAt(i)+"");
        }
        binaryTree.create(inList, postList);
//        System.out.print("二叉树先根遍历:");
//        binaryTree.preOrder(binaryTree.getRoot());
//        System.out.println();
//        System.out.print("二叉树中根遍历:");
//        binaryTree.inOrder(binaryTree.getRoot());
//        System.out.println();
//        System.out.print("二叉树后根遍历:");
//        binaryTree.postOrder(binaryTree.getRoot());
//        System.out.println();
//
//        System.out.print("二叉树叶子结点为:");
//        binaryTree.leaf();
//        System.out.println();
//
//        System.out.print("查找p结点的父母结点:");
//        BinaryNode p = binaryTree.getRoot().left.right.left;
//        binaryTree.parent(p);

//        System.out.println("验证二叉树的性质3：n0=n2+1");
//        BinaryTree.property3(binaryTree);

        System.out.println("原二叉树：");
        binaryTree.inOrder(binaryTree.getRoot());
        System.out.println();
        System.out.println("交换左右子树：");
        BinaryTree.swap1(binaryTree);
        System.out.println();

        binaryTree.create(inList, postList);
        System.out.println("原二叉树：");
        binaryTree.inOrder(binaryTree.getRoot());
        System.out.println();
        System.out.println("交换左右子树：");
        BinaryTree.swap2(binaryTree);
        System.out.println();

        binaryTree.create(inList, postList);
        System.out.println("原二叉树：");
        binaryTree.inOrder(binaryTree.getRoot());
        System.out.println();
        System.out.println("交换左右子树：");
        BinaryTree.swap3(binaryTree);
    }
}
