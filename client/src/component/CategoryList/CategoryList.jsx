import { useContext, useState } from "react"; //  Corrected!
import { AppContext } from "../../Context/Context";
import './CategoryList.css';
import { deleteCategory } from "../../service/CategoryService";
import toast from "react-hot-toast";

const CategoryList = () => {
    const { categories, setCategories } = useContext(AppContext);
    const[searchTerm , setSearchTerm] = useState('');

    const filteredCategories =  categories.filter( category => 
        category.name.toLowerCase().includes(searchTerm.toLowerCase())
    );



    return (
        <div className="category-list-container" style={{ height: '100vh', overflowY: 'auto', overflowX: 'hidden' }}>
                        {/* // search bar to items */}
                <div className="row pe-2">
                        <div className="input-group mb-3">
                            <input type="text"  name="keyword" id="keyword" placeholder="Search by keyword" className="form-control"
                            onChange={(e) => setSearchTerm(e.target.value)}
                            value={searchTerm} />

                            <span className="input-group-text bg-warning">
                                <i className="bi bi-search"></i>
                            </span>
                        </div>
                </div>

                {/* // categories list print */}
            <div className="row g-3 pe-2">
                {filteredCategories.map((category, index) => (
                    <div key={index} className="col-12">
                        <div className="card p-3" style={{ backgroundColor: category.bgColor }}>
                            <div className="d-flex align-items-center">
                                <div style={{ marginRight: '15px' }}>
                                    <img src={category.imgUrl} alt={category.name} className="category-image" />
                                </div>
                                <div className="flex-grow-1">
                                    <h5 className="mb-1 text-white">{category.name}</h5>
                                    <p className="mb-0 text-white">5 items</p>
                                </div>
                                <div>
                                    <button className="btn btn-danger btn-sm"
                                        >
                                        <i className="bi bi-trash"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default CategoryList;
