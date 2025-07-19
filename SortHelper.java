// Name: Michael Miralles
// Date: July 18, 2025
/** Description: This file contains a recursive merge sort function for sorting
*                an ArrayList of Book objects alphabetically by title.
*/

import java.util.ArrayList;

public class SortHelper {

    
    // Recursively sorts a list of Book objects by title using the merge sore algorithm
    public static ArrayList<Book> mergeSort(ArrayList<Book> books) {

        // Base case: a list with 0 or 1 element is already sorted
        if (books.size() <= 1) {
            return books;
        }

        // Split the list
        int mid = books.size() / 2;
        ArrayList<Book> left = new ArrayList<>();
        ArrayList<Book> right = new ArrayList<>();

        for (int i = 0; i < books.size(); i++) {
            if (i < mid) {
                left.add(books.get(i));
            }
            else {
                right.add(books.get(i));
            }
        }


        // Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the sorted halves and return the result
        return merge(left, right);
    }

    // Merges two sorted ArrayLists of Book objects into a single sorted list.
    private static ArrayList<Book> merge(ArrayList<Book> left, ArrayList<Book> right) {
        ArrayList<Book> result = new ArrayList<>();
        int i = 0;
        int j = 0;


        // Merge elements from both lists in sorted order
        while (i < left.size() && j < right.size()) {
            String titleLeft = left.get(i).getTitle().toLowerCase();
            String titleRight = right.get(j).getTitle().toLowerCase();

            if (titleLeft.compareTo(titleRight) <= 0) {
                result.add(left.get(i));
                i++;
            }
            else {
                result.add(right.get(j));
                j++;
            }
        }

        // Append leftover elements from left side of the list
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        // Append leftover elements from right side of the list
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
