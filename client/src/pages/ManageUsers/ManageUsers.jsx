import UserForm from '../../component/UserForm/UserForm';
import './ManageUser.css'
const ManageUsers = () =>{
    return (
       
        <div className="user-container text-light">
            <div className="left-column">
                <UserForm />
            </div>
            <div className="right-column">
                list of User
            </div>
        </div>
    );
}

export default ManageUsers;