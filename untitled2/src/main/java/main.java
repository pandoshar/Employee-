import java.util.Date;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Instantiate EmployeeData for database operations
        EmployeeData employeeData = new EmployeeData();

        // Step 1: Create a new Employee and insert it into the database
        System.out.println("Creating a new employee...");
        Employee newEmployee = new Employee(0, "Alice Johnson", "Developer", 60000.0, new Date());
        employeeData.createEmployee(newEmployee);

        // Step 2: Retrieve and display an employee by ID
        System.out.println("\nRetrieving employee by ID...");
        int searchId = 1; // Change this to the ID of an existing employee in your database
        Employee employeeById = employeeData.getEmployeeById(searchId);
        if (employeeById != null) {
            System.out.println("Employee found: " + employeeById);
        } else {
            System.out.println("No employee found with ID: " + searchId);
        }

        // Step 3: Retrieve and display all employees
        System.out.println("\nRetrieving all employees...");
        List<Employee> allEmployees = employeeData.getAllEmployees();
        if (allEmployees.isEmpty()) {
            System.out.println("No employees found in the database.");
        } else {
            for (Employee emp : allEmployees) {
                System.out.println(emp);
            }
        }

        // Step 4: Update an employee's details
        if (employeeById != null) {
            System.out.println("\nUpdating employee details...");
            employeeById.setSalary(70000.0); // Update salary
            employeeById.setPosition("Senior Developer"); // Update position
            employeeData.updateEmployee(employeeById);
            System.out.println("Updated employee: " + employeeData.getEmployeeById(searchId));
        }

        // Step 5: Delete an employee by ID
        System.out.println("\nDeleting an employee...");
        int deleteId = 1; // Change this to the ID of an employee to delete
        employeeData.deleteEmployee(deleteId);

        // Verify deletion
        System.out.println("\nVerifying deletion...");
        Employee deletedEmployee = employeeData.getEmployeeById(deleteId);
        if (deletedEmployee == null) {
            System.out.println("Employee with ID " + deleteId + " has been successfully deleted.");
        } else {
            System.out.println("Deletion failed for employee: " + deletedEmployee);
        }
    }
}
