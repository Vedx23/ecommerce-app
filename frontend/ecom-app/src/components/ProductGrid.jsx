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
    // Add more product data as needed
  ];

  return (<>
  <div className='min-w-full p-4 text-white border border-white'>
      <ul>
        <h2>
          sort by
        </h2>
        <li>
          
        </li>
      </ul>
  </div>
  <div className="grid grid-cols-1 gap-x-4 gap-y-4 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 p-4">
      {/* Map over products array and render ProductCard for each */}
      {products.map(product => (
        <ProductCard key={product.id} product={product} />
      ))}
    </div>
  </>
  );
};

export default ProductGrid;
