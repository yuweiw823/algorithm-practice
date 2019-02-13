using System;
using System.Collections.Generic;

namespace CSharp
{
    class Node
    {
        public int label;
        public List<Node> neighbours;

        public Node(int label)
        {
            this.label = label;
            this.neighbours = new List<Node>();
        }

    }
    class Program
    {
        static List<Node> result = new List<Node>();
        static void Main(string[] args)
        {
            Node node0 = new Node(0);
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            Node node5 = new Node(5);

            node0.neighbours = new List<Node>(){node1, node2, node3};
            node1.neighbours = new List<Node>(){node4};
            node2.neighbours = new List<Node>(){node4, node5};
            node3.neighbours = new List<Node>(){node4, node5};
            
            List<Node> graph = new List<Node>(){node0, node1, node2, node3, node4, node5};

            result = topSort(graph);

            foreach(Node node in result)
            {
                System.Console.Write(node.label + ", ");
            }
        }

        static List<Node> topSort(List<Node> graph)
        {
            Dictionary<Node, int> map = new Dictionary<Node, int>();
            Queue<Node> q = new Queue<Node>(0);

            //1. Build the map
            foreach(Node node in graph)
            {
                foreach(Node neighbour in node.neighbours)
                {
                    if(!map.ContainsKey(neighbour))
                    {
                        map[neighbour] = 1;
                    }
                    else
                    {
                        map[neighbour] = map[neighbour] + 1;
                    }
                }
            }

            foreach(Node node in graph)
            {
                if(!map.ContainsKey(node))
                {
                    result.Add(node);
                    q.Enqueue(node);
                }
            }

            while(q.Count > 0)
            {
                Node curr = q.Dequeue();
                foreach(Node node in curr.neighbours)
                {
                    map[node] = map[node] - 1;
                    if(map[node] == 0)
                    {
                        result.Add(node);
                        q.Enqueue(node);
                    }
                }
            }

            return result;
        }
    }
}
