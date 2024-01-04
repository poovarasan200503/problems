// You are using GCC
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
};

Node* insert(Node* root, int val) {
    if (root == NULL){
        Node* newnode = new Node();
        newnode->data = val;
        newnode->left = NULL;
        newnode->right = NULL;
        return newnode;
    }
    if (val < root->data) {
        root->left = insert(root->left, val);
    }
    else {
        root->right = insert(root->right, val);
    }
    return root;
}

void inorder(Node* root) {
    if (root != NULL) 
    {
        inorder(root->left);
        cout << root->data << " ";
        inorder(root->right);
    }
}

void preorder(Node* root) {
    if (root != NULL) 
    {
        cout << root->data << " ";
        preorder(root->left);
        preorder(root->right);
    }
}

void postorder(Node* root) {
    if (root != NULL) {
        postorder(root->left);
        postorder(root->right);
        cout << root->data << " ";
    }
}

void levelorder(Node* root) {
    if (root == NULL) 
        return;

    queue<Node*> q;
    q.push(root);
    while (!q.empty()) {
        int ss=q.size();
        for(int i=0;i<ss;i++)
        {
            
        Node* current = q.front();
        cout << current->data << " ";
        q.pop();

        if (current->left != NULL)
            q.push(current->left);
        if (current->right != NULL)
            q.push(current->right);
        }
        cout<<endl;
    }
}
void verticalorder(Node* root,map<int,vector<int>>&mp,int val)
{
    if(root!=NULL)
    {
        mp[val].push_back(root->data);
        verticalorder(root->left,mp,val-1);
        verticalorder(root->right,mp,val+1);
    }
}

int main() {
    Node* root = NULL;
    int val;
    cin >> val;
    while ( val > 0 ) {
        root = insert( root, val);
        cin>>val;
    }
    cout << "Preorder Traversal:" << endl;
    preorder( root ); 
    cout << endl;
    cout << "Inorder Traversal:" << endl;
    inorder( root ); 
    cout << endl;
    cout << "Postorder Traversal:" << endl;
    postorder( root ); 
    cout << endl;
    cout << "Levelorder Traversal:" << endl;
    levelorder( root ); 
    cout << endl;
    cout << "Vertical Traversal:" << endl;
    map<int,vector<int>>mp;
    verticalorder(root,mp,0);
    for(auto mm:mp)
    {
        for(auto vv:mm.second)
        {
            cout<<vv<<" ";
        }
        cout<<endl;
    }
    return 0;
}
