import React from 'react'
import styles from '../styles/NavBar.module.css'
function NavBar() {
    return (
        <nav className={styles.navbar}>
                <ul className={styles.ul}>
                    <li className={styles.li_icon}>
                        <img src="icon.png" alt="icon" className={styles.icon}/>
                    </li>
                    <li className={styles.li_search}>
                        <input type="text" className={styles.li_search_input} />
                        <img src="search.svg" alt="search" className={styles.li_search_img}/>
                    </li>
                    <li className={styles.li}>
                        <span className={styles.li_user_name}>Julian Ippolito</span>
                        <img src="" alt="perfil" className={styles.li_user_img} />
                    </li>
                </ul>
        </nav>
    )
}

export default NavBar