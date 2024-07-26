#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

int main()
{
    ifstream inputFile("input.txt");
    ofstream outputFile("output.txt");

    int n;
    inputFile >> n;
    vector<int> arr(n);

    // Taking Original Array values
    for (int i = 0; i < n; i++)
    {
        inputFile >> arr[i];
    }

    // Precompute in Array
    vector<int> hash(13, 0);
    for (int i = 0; i < n; i++)
    {
        hash[arr[i]] += 1;
    }

    int q;
    inputFile >> q;
    while (q > 0)
    {
        int number;
        inputFile >> number;

        // Fetch from hash array and write to the output file
        outputFile << hash[number] << endl;
        q--;
    }

    // Close input and output files
    inputFile.close();
    outputFile.close();

    return 0;
}