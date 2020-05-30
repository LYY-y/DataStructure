package Chapter6;

import Chapter2.SeqList;

public class BinaryTree<T> {
    private static int n0;
    private static int n2;
    private BinaryNode<T> root;

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }

    public int getN0() {
        return n0;
    }

    public void setN0(int n0) {
        this.n0 = n0;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public BinaryTree() {
        this.root = null;
        this.n0 = 0;
        this.n2 = 0;
    }

    //以中根和后根遍历序列构造二叉树
    public BinaryTree<T> create(SeqList<T> inList, SeqList<T> postList){
        this.setRoot(buildBiTree(inList, 0, inList.size()-1, postList,  0, postList.size()-1));
        return this;
    }

    public BinaryNode<T> buildBiTree(SeqList<T> inList, int inStart, int inEnd, SeqList<T> postList, int postStart, int postEnd){
        if (postStart <= postEnd){
            T r = postList.get(postEnd);
            BinaryNode<T> node = new BinaryNode<T>(r);
            int rIndex = inList.search(r);
            int leftLen = rIndex - inStart;
            int rightLen = inEnd - rIndex;
            node.setLeft(buildBiTree(inList, inStart,rIndex-1, postList, postEnd - leftLen-rightLen,postEnd-rightLen-1));
            node.setRight(buildBiTree(inList, rIndex+1, rIndex+rightLen, postList, postEnd-rightLen, postEnd-1));
            return node;
        }else return null;
    }

    //输出叶子结点
    public void leaf(){
        this.findLeaf(this.getRoot());
    }

    public void findLeaf(BinaryNode<T> p){
        if (p != null) {
            if (p.left == null && p.right == null) {
                System.out.print(p.data.toString());
            }
            findLeaf(p.left);
            findLeaf(p.right);
        }
    }


    //返回p结点的父母结点
    public BinaryNode<T> parent(BinaryNode<T> p){
        return this.findParent(p, getRoot());
    }

    public BinaryNode<T> findParent(BinaryNode<T> p, BinaryNode<T> node){
        if (node != null) {
            if (node.left == p || node.right == p) {
                System.out.println(node.data.toString());
                return node;
            }
            findParent(p, node.left);
            findParent(p, node.right);
        }
        return null;
    }

    //验证二叉树的性质3：n0=n2+1
    public static<T> void property3(BinaryTree<T> bitree){
        count(bitree.getRoot());
        System.out.println("度为0的结点数目：" + n0);
        System.out.println("度为2的结点数目：" + n2);
        System.out.println("n0=n2+1是否成立：" + (n0 == n2+1));
    }

    public static<T> void count(BinaryNode<T> p){
        if (p != null){
            if (p.left == null && p.right == null){
                n0++;
            }
            if (p.left != null && p.right != null){
                n2++;
            }
            count(p.left);
            count(p.right);
        }
    }

    //交换结点的左右子树，讨论3种遍历算法的可行性
    //swap1先根遍历
    public static<T> void swap1(BinaryTree<T> bitree){
        BinaryNode<T> p = bitree.getRoot();
        if (p == null){
            return;
        }
        System.out.print(p.data.toString() + " ");
        BinaryNode<T> temp = p.left;
        p.left = p.right;
        p.right = temp;
        bitree.setRoot(p.left);
        swap1(bitree);
        bitree.setRoot(p.right);
        swap1(bitree);
    }

    //swap2中根遍历
    public static<T> void swap2(BinaryTree<T> bitree){
        BinaryNode<T> p = bitree.getRoot();
        if (p == null){
            return;
        }
        bitree.setRoot(p.left);
        swap2(bitree);

        System.out.print(p.data.toString() + " ");
        BinaryNode<T> temp = p.left;
        p.left = p.right;
        p.right = temp;

        bitree.setRoot(p.left);
        swap2(bitree);
    }

    //swap3后根遍历
    public static<T> void swap3(BinaryTree<T> bitree){
        BinaryNode<T> p = bitree.getRoot();
        if (p == null){
            return;
        }
        bitree.setRoot(p.left);
        swap3(bitree);
        bitree.setRoot(p.right);
        swap3(bitree);
        System.out.print(p.data.toString() + " ");
        BinaryNode<T> temp = p.left;
        p.left = p.right;
        p.right = temp;
    }

    //先根遍历
    public void preOrder(BinaryNode<T> p){
        if (p != null){
            System.out.print(p.data.toString() + " ");
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    //中根遍历
    public void inOrder(BinaryNode<T> p){
        if (p != null){
            inOrder(p.left);
            System.out.print(p.data.toString() + " ");
            inOrder(p.right);
        }
    }

    //后根遍历
    public void postOrder(BinaryNode<T> p){
        if (p != null){
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.data.toString() + " ");
        }
    }


}
