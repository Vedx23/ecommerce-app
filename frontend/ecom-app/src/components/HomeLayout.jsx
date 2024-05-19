import React from 'react'
import Navbar from "./Navbar"
import ProductGrid from './ProductGrid'
const HomeLayout = () => {
  return (
    <>
      <Navbar></Navbar>
      <div className='flex flex-row bg-gradient-to-tr from-black to-gray-700'>
        <div className='border border-white w-3/12 min-h-full p-4'>
          <div className='border border-white w-full h-5/6'>
            <p className='text-4xl font-mono font-semibold text-center text-slate-100'> Filter by </p>
          </div>
        </div>
        <div className='border border-slate-100 w-full'>
          <ProductGrid></ProductGrid>
        </div>
      </div>
    </>
  )
}

export default HomeLayout