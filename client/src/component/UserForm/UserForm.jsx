const UserForm =()=>{
    return (
        <div className="mx-2 mt-2">
            <div className="row">
                <div className="card col-md-8 form-container">
                    <div className="card-body">
                        <form >
                           
                            <div className="mb-3">
                                <label htmlFor="name" className="form-label">Name</label>
                                <input type="text" name="name" id="name" placeholder="User-Name" className="form-control" />
                            </div>
                            <div className="mb-3">
                                <label htmlFor="email" className="form-label">Email</label>
                                <input type="email" name="email" id="email" placeholder="Useremail@gmail.com" className="form-control" />
                            </div>
                            <div className="mb-3">
                                <label htmlFor="password" className="form-label">password</label>
                                <input type="password" name="password" id="password" placeholder="***********" className="form-control" />
                            </div>
                            <button type="submit" className="btn btn-warning w-100" >save</button>
                        </form>
                    </div>
                </div>
            </div>
       </div>
    )
}

export default UserForm;