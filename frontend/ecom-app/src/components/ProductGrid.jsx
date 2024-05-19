import React from 'react';
import ProductCard from './ProductCard'; // Import your ProductCard

const ProductGrid = () => {
  // Sample product data
  const products = [
    { id: 1, name: 'Nike Air poison frog', description: 'Organic h-tech soul shoes', price: '₹1299', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 2, name: 'Adidas Boost', description: 'Comfortable running shoes', price: '₹1499', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 3, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 4, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 5, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 6, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 7, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 8, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 9, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 10, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 11, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 12, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 13, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    { id: 14, name: 'Puma Blaze', description: 'Stylish urban sneakers', price: '₹1099', image: 'https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg' },
    // Add more product data as needed
  ];

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 mt-4 border-4 border-black">
      {/* Map over products array and render ProductCard for each */}
      {products.map(product => (
        <ProductCard key={product.id} product={product} />
      ))}
    </div>
  );
};

export default ProductGrid;
