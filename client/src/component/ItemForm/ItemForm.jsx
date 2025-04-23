const ItemForm =()=>{
    return (
       <div className="item-form-container" style={{height:'100vh',overflowY:'auto', overflowX:'hidden'}}>
         <div className="mx-2 mt-2">
        <div className="row">
            <div className="card col-md-8 form-container">
                <div className="card-body">
                    <form >
                        <div className="mb-3">
                            <label htmlFor=" image" className="form-label">
                                <img src="https://placehold.co/48x48" alt="" width={48} />
                            </label>
                            <input type="file" name="image" id="image" className="form-control" hidden />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="name" className="form-label">Name</label>
                            <input type="text" name="name" id="name" placeholder="Item-name" className="form-control" />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="category" className="form-label"> Category</label>
                            <select name="category" id="category" className="form-control">
                                <option value="">---select category---</option>
                                <option value="category-1">category-1</option>
                                <option value="category-2">category-2</option>
                                <option value="category-3">category-3</option>
                            </select>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="price" className="form-label">Price</label>
                            <input type="number" name="price" id="price" placeholder="&#8377;200.00" className="form-control" />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="name" className="form-label">Description</label>
                            <textarea rows="5" name="descp" id="descp" placeholder="Write content here..." className="form-control" ></textarea>
                        </div>
                       
                        <button type="submit" className="btn btn-warning w-100" >save</button>
                    </form>
                </div>
            </div>
        </div>
   </div>
       </div>
    )
}

export default ItemForm;