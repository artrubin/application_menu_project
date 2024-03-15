# application_menu_project
Java application with an interactive menu offering various options for user selection and implementation.

For one of my academic projects in Java, I was tasked with creating an application designed to compute and present statistics for a rugby tournament, based on user-provided data.

Upon initiation, the application presents the following menu to the user, prompting for a selection:

**Rugby Tournament Application Menu:**
1. Input details for a new item
2. Show details of the most recently inputted item
3. Reveal the team with the highest points
4. Show the team with the lowest points
5. Calculate and display the average points of all teams
6. Terminate the application
   - **Enter your choice:**

The application was developed to fulfill the following requirements:

1. **Input Item Details:**
   - Users can input information for a new item, restricted to one item per selection of option 1. To input another item, the user must select option 1 again.
   - An item is only created if the mandatory fields are valid. If not, the user is prompted to re-enter valid information.

2. **Display Last Item:**
   - The application shows the details of the last item entered. If there are no items, a message informs the user accordingly.

3. **Team with Highest Points:**
   - Displays the team with the highest points in the format "Metric value". If multiple items meet this criterion, the first entered item satisfying it is shown.

4. **Team with Lowest Points:**
   - Similar to the highest points functionality, but for the lowest points. The first item meeting the criterion is displayed.

5. **Average Points Score:**
   - The application calculates and displays the average points scored by all teams entered.

6. **Application Termination:**
   - Users can repeatedly access all functions until they choose to exit the application by selecting option 6, at which point the application ceases operation.

The application ensures validation for all numerical inputs, prompting the user to re-enter valid data upon receiving invalid input.
