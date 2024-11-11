// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract CustomerData {
    struct Customer {
        uint id;
        string name;
        uint age;
        string phoneNo;
    }

    Customer[] private customers;
    mapping(uint => bool) public customerExists;
    mapping(uint => Customer) private customerData;

    event CustomerAdded(uint id, string name, uint age, string phoneNo);

    receive() external payable {}
    fallback() external payable {}

    // Function to add a new customer with validation
    function addCustomer(uint _id, string memory _name, uint _age, string memory _phoneNo) public {
        require(!customerExists[_id], "Customer ID already exists.");
        require(bytes(_phoneNo).length == 10, "Phone number must be exactly 10 digits.");

        Customer memory newCustomer = Customer(_id, _name, _age, _phoneNo);
        customers.push(newCustomer);
        customerExists[_id] = true;
        customerData[_id] = newCustomer;

        emit CustomerAdded(_id, _name, _age, _phoneNo);
    }

    // Function to get the total number of customers
    function getCustomerCount() public view returns (uint) {
        return customers.length;
    }

    // Function to get customer details by ID
    function getCustomerById(uint _id) public view returns (uint, string memory, uint, string memory) {
        require(customerExists[_id], "Customer ID does not exist.");
        Customer memory customer = customerData[_id];
        return (customer.id, customer.name, customer.age, customer.phoneNo);
    }
}
