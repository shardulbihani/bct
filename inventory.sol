// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract ProductInventory {
    struct Product {
        string name;
        uint256 quantity;
        uint256 price;
    }
    
    mapping(string => Product) private products;
    uint256 public count;

    // Function to add or update a product in the inventory
    function receiveProduct(string memory _name, uint256 _quantity, uint256 _price) public {
        require(bytes(_name).length > 0, "Product name required");
        require(_quantity > 0, "Quantity should be greater than zero");
        require(_price > 0, "Price should be greater than zero");
        
        // Check if the product already exists
        if (products[_name].quantity == 0) {
            count++;
        }
        
        products[_name] = Product(_name, _quantity, _price);
    }

    // Function to sell a product
    function saleProduct(string memory _name, uint256 _quantity) public {
        Product storage product = products[_name];
        require(bytes(product.name).length > 0, "Product not found");
        require(product.quantity >= _quantity, "Insufficient stock");
        
        product.quantity -= _quantity;
        
        // Decrease the count if the product is fully sold out
        if (product.quantity == 0) {
            count--;
        }
    }

    // Function to display stock details of a product
    function displayStock(string memory _name) public view returns (string memory, uint256, uint256) {
        Product memory product = products[_name];
        require(bytes(product.name).length > 0, "Product not found");

        return (product.name, product.quantity, product.price);
    }
}
