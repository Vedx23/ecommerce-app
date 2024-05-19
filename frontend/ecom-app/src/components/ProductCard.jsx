import React from 'react';
import 'tailwindcss/tailwind.css';
import 'daisyui/dist/full.css';

const ProductCard = (props) => {
    return (
        <div className="card shadow-md w-full max-w-xs mx-auto bg-slate-100">
            <div className="flex flex-col h-full">
                <figure className="flex-grow-[7]">
                    <img
                        src="https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg"
                        alt="Shoes"
                        className="w-full h-full object-cover"
                    />
                </figure>
                <div className="card-body flex-grow-[2] p-4 flex flex-col justify-between">
                    <div>
                        <h2 className="card-title text-lg font-bold">Nike Air poison frog</h2>
                        <p className="text-sm">Organic h-tech soul shoes</p>
                        <p className="text-2xl font-mono font-semibold">₹1299</p>
                    </div>
                    <div>
                        <p className="badge badge-sm badge-success font-bold text-white mb-2">In Stock</p>
                        <div className="card-actions flex justify-between">
                            <button className="btn btn-sm btn-outline">Add to cart</button>
                            <div className='tooltip tooltip-error tooltip-top' data-tip="feature coming soon">
                            <button className="btn btn-sm btn-outline" disabled>Buy now</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default ProductCard;
