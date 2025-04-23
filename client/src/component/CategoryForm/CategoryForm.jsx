const CategoryForm = () =>{
    return(
       <div className="mx-2 mt-2" style={{height:'100vh',overflowY:'auto', overflowX:'hidden'}}>
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
                                <input type="text" name="name" id="name" placeholder="category-name" className="form-control" />
                            </div>
                            <div className="mb-3">
                                <label htmlFor="name" className="form-label">Description</label>
                                <textarea rows="5" name="descp" id="descp" placeholder="Write content here..." className="form-control" ></textarea>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="bgcolor" className="form-label">Background Color</label>
                               <br />
                                <input type="color" name="bgColor" id="bgcolor" placeholder="#ffffff" />
                            </div>
                            <button type="submit" className="btn btn-warning w-100" >save</button>
                        </form>
                    </div>
                </div>
            </div>
       </div>
    )
}
export default CategoryForm;