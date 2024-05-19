import React from 'react';
const Navbar = () => {
    return (
        <>
            <div className="navbar bg-base-100 flex items-center bg-gradient-to-br from-black to-gray-700">
                <div className="flex-1 flex items-center">
                    <a className="btn btn-ghost">
                        <img className='w-10' src="https://img.icons8.com/3d-fluency/94/weary-cat-1.png" alt="weary-cat-1" />
                    </a>
                    <div className="relative w-full max-w-xs ml-2">
                        <input
                            type="text"
                            placeholder="Search here!"
                            className="input input-sm border-2 rounded-sm bg-gray-700 w-full pr-10"
                        />
                       <button className='absolute top-0 right-0 btn btn-sm btn-ghost bg-gray-500 hover:bg-gray-400'>
                       <img width="16" height="16" src="https://img.icons8.com/ios/50/search--v1.png" alt="search--v1"/>
                       </button>
                    </div>
                </div>
                <div className="flex-none">
                    <div className="dropdown dropdown-end">
                        <div tabIndex={0} role="button" className="btn btn-ghost btn-circle avatar">
                            <div className="w-10 rounded-full">
                                <img src="" />
                            </div>
                        </div>
                        <ul tabIndex={0} className="menu menu-sm dropdown-content mt-3 z-[1] p-2 shadow bounded-box w-52 bg-white">
                            <li>
                                <a className='m-px' >Cart</a>
                            </li>
                            <li>
                                <a className='m-px' >
                                    Profile
                                </a>
                            </li>
                            <li>
                                <a className='m-px' >Settings</a>
                            </li>
                            <li><a className='m-px btn btn-sm btn-ghost bg-red-600' >Logout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Navbar