import ItemForm from '../../component/ItemForm/ItemForm';
import ItemList from '../../component/ItemList/ItemList';
import './ManageItem.css'
const ManageItem = () =>{
    return (
        <div className="items-container text-light">
        <div className="left-column">
          <ItemForm />
        </div>
        <div className="right-column">
            <ItemList />
        </div>
    </div>
    );
}

export default ManageItem;